import React, { useState } from "react";
import { Grid } from "@material-ui/core";
import { makeStyles } from '@material-ui/core/styles';

// components
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import PageTitle from "../../components/PageTitle";
import { getVehicleInfo, generateBill } from "../../services/servicesApi";

const useStyles = makeStyles(theme => ({
  appBar: {
    position: 'relative',
  },
  layout: {
    width: 'auto',
    marginLeft: theme.spacing(2),
    marginRight: theme.spacing(2),
    [theme.breakpoints.up(900 + theme.spacing(2) * 2)]: {
      width: 900,
      marginLeft: 'auto',
      marginRight: 'auto',
    },
  },
  paper: {
    marginTop: theme.spacing(3),
    marginBottom: theme.spacing(3),
    padding: theme.spacing(2),
    [theme.breakpoints.up(900 + theme.spacing(3) * 2)]: {
      marginTop: theme.spacing(6),
      marginBottom: theme.spacing(6),
      padding: theme.spacing(3),
    },
  },
  stepper: {
    padding: theme.spacing(3, 0, 5),
  },
  buttons: {
    display: 'flex',
    justifyContent: 'flex-end',
  },
  button: {
    marginTop: theme.spacing(3),
    marginLeft: theme.spacing(1),
  },
}));

export default function VehicleOutPage() {
  var classes = useStyles();
  var [vehicleNo, setVehicleNo] = useState('');
  var [vechileInfo, setVehicleInfo] = useState(null);

  const handleGetVehicleInfo = () => {
    getVehicleInfo(vehicleNo).then(response => {
      setVehicleInfo(response);
    });
  }
  const handleGenerateBill = () => {
    generateBill(vehicleNo).then(response => {
      setVehicleInfo(response);
    });
  }
  const handleOnChange = event => {
    setVehicleNo(event.target.value)
  }
  return (
    <>
      <PageTitle title="Vehicle Out" />
      <main className={classes.layout}>
        <Grid container spacing={3} >
          <Grid item xs={12}>
            <Paper className={classes.paper}>
              <Typography component="h1" variant="h4" align="center">
                Bill Generation
              </Typography>
              <React.Fragment>
                <Grid container spacing={3} >
                  <Grid item xs={12}>
                    <TextField
                      required
                      id="vehicleNo"
                      name="vehicleNo"
                      label="Vehicle No"
                      onChange={handleOnChange}
                      fullWidth
                      value={vehicleNo}
                    />
                  </Grid>
                  <div className={classes.buttons}>
                    <Button
                      variant="contained"
                      color="primary"
                      onClick={handleGetVehicleInfo}
                      className={classes.button}
                    >Get Vehicle Info</Button>
                    <Button
                      variant="contained"
                      color="primary"
                      onClick={handleGenerateBill}
                      className={classes.button}
                    >Generate Bill</Button>
                  </div>
                </Grid>
              </React.Fragment>
            </Paper>
          </Grid>
        </Grid>
        {
          vechileInfo ?
            <Grid container spacing={3} >
              <Grid item xs={12}>
                <Paper className={classes.paper}>
                  <Typography component="h1" variant="h4" align="center">
                    Bill Generation
                  </Typography>
                  <dl>
                    {
                      Object.keys(vechileInfo).map(item => (
                        <span key={item}>
                          <dt>{item}</dt>
                          <dd>{vechileInfo[item]}</dd>
                        </span>
                      ))
                    }
                  </dl>
                </Paper>
              </Grid>
            </Grid>
            :
            null
        }
      </main>
    </>
  );
}
