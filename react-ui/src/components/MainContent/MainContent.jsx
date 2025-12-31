import MonthlyCalendar from "../MonthlyCalendar/MonthlyCalendar";

function MainContent() {
  const year = 2026;
  const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];

  return (
    <div>
      {months.map((month) => (
        <MonthlyCalendar month={month} year={year} />
      ))}
    </div>
  );
}

export default MainContent;
