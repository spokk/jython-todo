import React from 'react';
import { AppState } from './reducers/interfaces';

import { useSelector, useDispatch } from 'react-redux';

import './App.sass';

const App: React.FC = () => {
  const test = useSelector((state: AppState) => state.test.test);
  const dispatch = useDispatch();
  return (
    <div className="App">
      <header className="App-header">
        <h1>{test}</h1>
        <button onClick={() => dispatch({ type: 'TEST_ASYNC' })}>Button</button>
      </header>
    </div>
  );
};

export default App;
