import { useEffect, useState } from "react";
import MonthlyCalendar from "../MonthlyCalendar/MonthlyCalendar";
import "./MainContent.css";

function MainContent() {
  const [years, setYears] = useState(null);
  const [selectedYear, setSelectedYear] = useState(new Date().getFullYear());

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch("/api/configuration/years");
      const yearsJson = await response.json();
      setYears(yearsJson);
    };

    fetchData();
  }, []);

  const months = [
    { idx: 0, name: "January" },
    { idx: 1, name: "February" },
    { idx: 2, name: "March" },
    { idx: 3, name: "April" },
    { idx: 4, name: "May" },
    { idx: 5, name: "June" },
    { idx: 6, name: "July" },
    { idx: 7, name: "August" },
    { idx: 8, name: "September" },
    { idx: 9, name: "October" },
    { idx: 10, name: "November" },
    { idx: 11, name: "December" },
  ];

  const handleYearClick = (year) => {
    setSelectedYear(year);
  };

  return (
    <div className="container">
      <div className="d-flex gap-3">
        {years &&
          years.map((year) => (
            <div key={year}>
              <button
                type="button"
                className="btn btn-primary"
                onClick={() => handleYearClick(year)}>
                {year}
              </button>
            </div>
          ))}
      </div>
      <div className="year-grid-container">
        {months.map((month) => (
          <div className="year-item">
            <MonthlyCalendar month={month} year={selectedYear} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default MainContent;
