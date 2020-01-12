import React, { useState } from "react";
import facade from "../apiFacade.jsx";

const acceptable_categories = [
  "career",
  "celebrity",
  "dev",
  "explicit",
  "fashion",
  "food",
  "history",
  "money",
  "movie",
  "music",
  "political",
  "science",
  "sport",
  "travel"
];

const AdminPanel = ({ loggedIn, roles }) => {
  if (!loggedIn || !roles.includes("admin")) {
    return (
      <>
        <p>You are not logged in as admin</p>
      </>
    );
  } else {
    return (
      <>
        <AdminPage />
      </>
    );
  }
};

const AdminPage = () => {
  return <> Youre logged in as Admin. </>;
};

export default AdminPanel;
