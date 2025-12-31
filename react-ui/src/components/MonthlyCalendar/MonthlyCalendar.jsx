import { Button } from "react-bootstrap";
import "./MonthlyCalendar.css";

function MonthlyCalendar({ month, year }) {
  const currDate = new Date(year, month.idx, 1);
  const daysOfWeek = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
  let daysOfMonth = [];

  const day = currDate.getDay();
  while (daysOfMonth.length < day) {
    daysOfMonth.push(undefined);
  }

  while (currDate.getMonth() === month.idx) {
    daysOfMonth.push(currDate.getDate());
    currDate.setDate(currDate.getDate() + 1);
  }

  return (
    <div>
      <span>{month.name.toUpperCase()}</span>
      <div className="month-grid-container">
        {daysOfWeek.map((dayName, idx) => (
          <span className="month-item">
            <b>{dayName}</b>
          </span>
        ))}
      </div>
      <div className="month-grid-container">
        {daysOfMonth.map((day) => (
          <span className="month-item">{day}</span>
        ))}
      </div>
    </div>
  );
}

export default MonthlyCalendar;
