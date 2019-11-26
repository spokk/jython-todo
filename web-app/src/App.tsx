import React from 'react';
import store, { action } from './store';

import { Provider } from 'react-redux';

import './App.sass';

const App: React.FC = () => {
  return (
    <Provider store={store}>
      <div className="App">
        <header className="App-header">
          <a className="App-link" href="https://reactjs.org" target="_blank" rel="noopener noreferrer">
            Learn React
          </a>
          <button onClick={() => action('TEST_ASYNC')}>btn</button>
        </header>
      </div>
    </Provider>
  );
};

export default App;
