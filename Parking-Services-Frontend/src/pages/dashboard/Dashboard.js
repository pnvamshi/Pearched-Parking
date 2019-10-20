import React from "react";
import {
  Grid,
} from "@material-ui/core";

// styles
import useStyles from "./styles";

// components
import Widget from "../../components/Widget";
import PageTitle from "../../components/PageTitle";
import { Typography } from "../../components/Wrappers";


export default function Dashboard(props) {
  var classes = useStyles();

  return (
    <>
      <PageTitle title="Dashboard" />
      <div style={{ marginLeft: 'auto', marginRight: 'auto', width: 600 }}>

        <Grid container spacing={4}>
          <Grid item xs={12}>
            <Widget
              title="Entry Today"
              upperTitle
              bodyClass={classes.fullHeightBody}
              className={classes.card}
              disableWidgetMenu={true}
            >
              <div className={classes.visitsNumberContainer}>
                <Typography size="xl" weight="medium">
                  50
              </Typography>
              </div>
              <Grid
                container
                direction="row"
                justify="space-between"
                alignItems="center"
              >
                <Grid item>
                  <Typography color="text" colorBrightness="secondary">
                    In
                </Typography>
                  <Typography size="md">50</Typography>
                </Grid>
                <Grid item>
                  <Typography color="text" colorBrightness="secondary">
                    Out
                </Typography>
                  <Typography size="md">10</Typography>
                </Grid>
              </Grid>
            </Widget>
          </Grid>
        </Grid>
      </div>

    </>
  );
}
