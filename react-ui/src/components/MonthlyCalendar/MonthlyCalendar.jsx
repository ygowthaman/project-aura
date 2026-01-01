import { useState } from "react";
import "./MonthlyCalendar.css";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import ButtonGroup from 'react-bootstrap/ButtonGroup';

function MonthlyCalendar({ month, year }) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const currDate = new Date(year, month.idx, 1);
  const daysOfWeek = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
  let dates = [];

  const day = currDate.getDay();
  while (dates.length < day) {
    dates.push(undefined);
  }

  while (currDate.getMonth() === month.idx) {
    dates.push(new Date(currDate));
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
        {dates.map((day, idx) => {
          if (!day) {
            return <span key={idx} className="month-item"></span>;
          }
          const today = new Date();
          today.setHours(0, 0, 0, 0);
          const isPast = day < today;
          if (isPast) {
            return (
              <span key={idx} className="month-item">
                {day.getDate()}
              </span>
            );
          } else {
            return (
              <Button
                className="month-item future-date btn btn-secondary"
                onClick={handleShow}
              >
                {day.getDate()}
              </Button>
            );
          }
        })}
      </div>
      <Modal show={show} onHide={handleClose} centered>
        <ButtonGroup aria-label="Basic example">
          <Button
            className="btn btn-link disposition-sad"
            onClick={handleClose}
          >
            <i class="bi bi-emoji-frown-fill"></i>
          </Button>
          <Button
            className="btn btn-link disposition-normal"
            onClick={handleClose}
          >
            <i class="bi bi-emoji-smile-fill"></i>
          </Button>
          <Button
            className="btn btn-link disposition-happy"
            onClick={handleClose}
          >
            <i class="bi bi-emoji-laughing-fill"></i>
          </Button>
        </ButtonGroup>
      </Modal>
    </div>
  );
}

export default MonthlyCalendar;
