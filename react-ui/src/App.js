import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import Header from './components/Header/Header.jsx';
import MainContent from './components/MainContent/MainContent.jsx';

function App() {
  return (
    <div className="App">
      <header>
        <Header />
      </header>
      <section>
        <Routes>
          <Route path="/" element={<MainContent />} />
          {/* Add more routes here */}
        </Routes>
      </section>
    </div>
  );
}

export default App;
