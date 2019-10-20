import React from "react";
import { withRouter } from "react-router-dom";

import Header from "../../components/Header";
// import Sidebar from "../Sidebar";

function User(props) {
    return(
        <>
            <Header history={props.history} />

        </>
    )
}

export default withRouter(User);
