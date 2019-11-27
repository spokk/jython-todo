import { TEST } from '../actions/types';
import { Test } from './interfaces';

const initialState = {
  test: 0
};

interface Action {
  type: string;
  payload: any;
}

export default function(state = initialState, action: Action): Test {
  switch (action.type) {
    case TEST:
      return {
        ...state,
        test: action.payload
      };
    default:
      return state;
  }
}
