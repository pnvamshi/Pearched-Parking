import React, { useState, useEffect } from "react";
import { Grid } from "@material-ui/core";
import { makeStyles } from '@material-ui/core/styles';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel';

// components
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import PageTitle from "../../components/PageTitle";
import { saveVehicle, getRegions } from "../../services/servicesApi";

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

export default function VehicleInPage() {
  var classes = useStyles();

  const [values, setValues] = useState({
    parkingLotId: '',
    vehicleNumber: '',
    vehicleWeight: 0
  });

  const [regions, setRegions] = useState([])

  useEffect(() => {
    getRegions("getreion").then(response => {
      setRegions(response)
    })
  }, [])

  const handleChange = name => event => {
    let value = event.target.value;
    if (name === "vehicleWeight") {
      value = parseInt(value);
    }
    setValues({ ...values, [name]: value });
  };

  const handleSubmit = () => {
    saveVehicle(values);
  }

  return (
    <>
      <PageTitle title="Vehicle In" />
      <main className={classes.layout}>
        <Grid container spacing={3} >
          <Grid item xs={12}>
            <Paper className={classes.paper}>
              <Typography component="h1" variant="h4" align="center">
                Vehicle Information
              </Typography>
              <React.Fragment>
                
                <Grid container spacing={3} >
                  <Grid item xs={12}>
                    <TextField
                      required
                      id="vehicleNumber"
                      name="vehicleNumber"
                      label="Vehicle Number"
                      onChange={handleChange('vehicleNumber')}
                      fullWidth
                    />
                  </Grid>
                  <Grid item xs={12}>
                    <TextField
                      required
                      id="vehicleWeight"
                      name="vehicleWeight"
                      label="Vehicle Weight"
                      onChange={handleChange('vehicleWeight')}
                      fullWidth
                    />
                  </Grid>
                  <Grid item xs={12}>
                    <InputLabel htmlFor="parkingLotId">Parking Lot Id</InputLabel>
                    <Select
                      value={values.parkingLotId}
                      required
                      id="parkingLotId"
                      label="Parking Lot Id"
                      onChange={handleChange('parkingLotId')}
                      fullWidth
                    >
                      {
                        regions.map(region => (
                          <MenuItem key={region.parkingLotId} value={region.parkingLotId}>{region.parkingRegion}</MenuItem>
                        ))
                      }
                    </Select>
                  </Grid>
                  <div className={classes.buttons}>
                    <Button
                      variant="contained"
                      color="primary"
                      onClick={handleSubmit}
                      className={classes.button}
                    >Submit</Button>
                  </div>
                </Grid>
              </React.Fragment>
            </Paper>
          </Grid>
        </Grid>
      </main>
    </>
  );
}
