import './App.css';
import Header from './components/Header/Header.jsx';
import MainContent from './components/MainContent/MainContent.jsx';

function App() {
  return (
    <div className="App">
      <header className="w-full h-[50px] px-8 flex items-center">
        <Header />
      </header>
      <section class="px-8">
        <MainContent />
      </section>
    </div>
  );
}

export default App;
