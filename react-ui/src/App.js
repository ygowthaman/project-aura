import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Header from './components/Header/Header.jsx';
import MainContent from './components/MainContent/MainContent.jsx';

function App() {
  return (
    <div className="App">
      <header>
        <Header />
      </header>
      <section>
        <MainContent />
      </section>
    </div>
  );
}

export default App;
