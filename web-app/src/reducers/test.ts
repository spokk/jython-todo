import { TEST } from '../actions/types';

const initialState = {};

interface Action {
  type: string;
  payload: any;
}

export default function(state = initialState, action: Action) {
  switch (action.type) {
    case TEST:
      return {
        ...state,
        test: 'test1'
      };
    default:
      return state;
  }
}
