import React, { useState } from "react";
import { Button } from "react-bootstrap";

const acceptable_categories = [
  { Career: false },
  { celebrity: false },
  { dev: false },
  { explicit: false },
  { fashion: false },
  { food: false },
  { history: false },
  { money: false },
  { movie: false },
  { music: false },
  { political: false },
  { science: false },
  { sport: false },
  { travel: false }
];

const FourJokes = () => {
  const [categories, setCategories] = useState(acceptable_categories);

  const handleChange = e => {
    const name = e.target.name;

    console.log(acceptable_categories);
  };

  return (
    <>
      <br />
      <div>
        <form>
          {acceptable_categories.map((e, index) => {
            return (
              <div key={index}>
                <input
                  type="checkbox"
                  value={e}
                  name={Object.keys(e)}
                  onChange={handleChange}
                />{" "}
                {Object.keys(e)}
              </div>
            );
          })}
          <Button type="button" className="btn-primary">
            Submit
          </Button>
        </form>
      </div>
    </>
  );
};

export default FourJokes;
