import { combineReducers, Reducer } from 'redux';
import test from './test';
import { AppState } from './interfaces';

const rootReducer: Reducer<AppState> = combineReducers<AppState>({ test });

export default rootReducer;
