import React, { useState, useEffect } from "react";
import { makeStyles } from '@material-ui/core/styles';
import { Grid } from "@material-ui/core";
import MUIDataTable from "mui-datatables";
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import TextField from '@material-ui/core/TextField';
import ButtonGroup from '@material-ui/core/ButtonGroup';

// components
import PageTitle from "../../components/PageTitle";
import { getUsers, saveUser } from "../../services/servicesApi";

const useStyles = makeStyles(theme => ({
  form: {
    display: 'flex',
    flexDirection: 'column',
    margin: 'auto',
    width: 'fit-content',
  },
  formControl: {
    marginTop: theme.spacing(2),
    minWidth: 120,
  },
  formControlLabel: {
    marginTop: theme.spacing(1),
  },
}));

// data
export default function Tables() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [users, setUsers] = useState([]);
  const [role, setRole] = useState('admin');

  const handleRole = (event) => {
    setRole(event.target.value);
  }

  useEffect(() => {
    getUsers(role).then(response => {
      setUsers(response.map(item => [item, role, '']));
    })
  }, [role]);

  // let datatableData = [];
  // const userList = await getUsers({role: 'operator'});
  // if (userList.data.error){
  //   datatableData = [];
  // }else{
  //   datatableData = userList.data;
  // }

  const [values, setValues] = React.useState({
    userName: '',
    password: '',
    role: 'admin'
  });

  const handleChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
  };

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSubmit = () => {
    saveUser(values).then(response => {
      if (response) {
        setOpen(false);
      }
    })
  }

  const columns = [
    { name: "Username" },
    { name: "Role" },
    {
      name: "Actions",
      options: {
        customBodyRender: (value, tableMeta, updateValue) => {
          return (
            <ButtonGroup variant="outlined"
              color="secondary">
              <Button >
                {`Edit`}
              </Button>
              <Button >
                {`Delete`}
              </Button>
            </ButtonGroup>
          );
        }
      }
    }
  ];
  return (
    <>
      <PageTitle title="Admin" button={"Add User"} handleClick={handleClickOpen} />
      <Grid container spacing={4}>
        <Grid item xs={12}>
          <Select
            value={role}
            label="Role"
            onChange={handleRole}
          >
            <MenuItem value="admin">Admin</MenuItem>
            <MenuItem value="operator">Operator </MenuItem>
          </Select>
          <MUIDataTable
            className="mt-2"
            title="Operator List"
            data={users}
            columns={columns}
            options={{
              filterType: "dropdown",
              // responsive: "scroll"
            }}
          />
        </Grid>
      </Grid>
      <Dialog
        fullWidth={false}
        maxWidth={"md"}
        open={open}
        onClose={handleClose}
        aria-labelledby="max-width-dialog-title"
      >
        <DialogTitle id="max-width-dialog-title">Add User</DialogTitle>
        <DialogContent>
          <form className={classes.form} noValidate>
            <FormControl className={classes.formControl}>
              <TextField
                id="userName"
                label="Username"
                className={classes.textField}
                value={values.username}
                onChange={handleChange('userName')}
              />
            </FormControl>
            <FormControl className={classes.formControl}>
              <TextField
                id="password"
                label="Password"
                className={classes.textField}
                value={values.password}
                onChange={handleChange('password')}
              />
            </FormControl>
            <FormControl className={classes.formControl}>
              <InputLabel htmlFor="role">Role</InputLabel>
              <Select
                value={values.role}
                label="Role"
                onChange={handleChange('role')}
                inputProps={{
                  name: 'role',
                  id: 'role',
                }}
              >
                <MenuItem value="admin">Admin</MenuItem>
                <MenuItem value="operator">Operator </MenuItem>
              </Select>
            </FormControl>
          </form>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary" variant="outlined" >
            Cancel
          </Button>
          <Button onClick={handleSubmit} color="primary" variant="outlined">
            Save
          </Button>
        </DialogActions>
      </Dialog>
    </>
  );
}
