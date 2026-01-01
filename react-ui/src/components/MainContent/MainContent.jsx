import MonthlyCalendar from "../MonthlyCalendar/MonthlyCalendar";
import "./MainContent.css";

function MainContent() {
  const years = [new Date().getFullYear(), 2026];
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

  return (
    <div className="container">
      <div className="row justify-content-start">
        {years.map((year) => (
          <div className="col-4">
            <button type="button" className="btn btn-primary col col-lg-2">
              {year}
            </button>
          </div>
        ))}
      </div>
      <div className="year-grid-container">
        {months.map((month) => (
          <div className="year-item">
            <MonthlyCalendar month={month} year={years[0]} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default MainContent;
