import React, { useState } from "react";
import { Button } from "react-bootstrap";
import facade from "../apiFacade.jsx";

const acceptable_categories = {
  career: false,
  celebrity: false,
  dev: false,
  explicit: false,
  fashion: false,
  food: false,
  history: false,
  money: false,
  movie: false,
  music: false,
  political: false,
  science: false,
  sport: false,
  travel: false
};
const FourJokes = () => {
  const [categories, setCategories] = useState(acceptable_categories);
  const [jokes, setJokes] = useState({});

  const handleChange = e => {
    const name = e.target.value;
    setCategories({ ...categories, [name]: !categories[name] });
  };

  const handleSubmit = e => {
    e.preventDefault();

    const validCategories = [];

    Object.keys(categories).forEach(category => {
      if (categories[category] == true) validCategories.push(category);
    });

    if (validCategories.length > 4) {
      return;
    }

    const myCategories = validCategories.map((element, index) => {
      if (index == 0) return element;
      return element;
    });

    facade
      .fetchFourJokes(myCategories)
      .then(res => {
        setJokes(res);
        console.log(res);
      })
      .catch(err => {
        if (err.status) {
          err.fullError.then(e => {
            console.log(e.code, e.message);
          });
        } else {
          console.log("Network error");
        }
      });
  };

  return (
    <>
      <br />
      <div>
        <h3> Select jokes </h3>
        <h5> You may only select up to 4. </h5>
        <form>
          {Object.keys(categories).map((e, index) => {
            return (
              <div key={index}>
                <input type="checkbox" value={e} onChange={handleChange} />
                {e}
              </div>
            );
          })}
          <Button type="button" className="btn-primary" onClick={handleSubmit}>
            Submit
          </Button>
        </form>
      </div>
      <p> Results: {JSON.stringify(jokes)}</p>
    </>
  );
};

export default FourJokes;
