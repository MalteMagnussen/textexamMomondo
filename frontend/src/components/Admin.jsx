import React, { useState } from "react";
import facade from "../apiFacade.jsx";

const AdminPanel = ({ loggedIn, roles }) => {
  if (!loggedIn || !roles.includes("admin")) {
    return (
      <>
        <p>You are not logged in as admin</p>
      </>
    );
  } else {
    return <p>You are logged in as admin</p>;
  }
};

export default AdminPanel;
