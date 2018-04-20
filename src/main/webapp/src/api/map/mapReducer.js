import { MAP_FETCH } from './mapActions'

const mapReducer = (state = {}, action) => {
  switch (action.type) {
    case MAP_FETCH + '_SUCCESS':
      return {
        ...state,
        points: action.response
      }
    case MAP_FETCH + '_FAILURE':
      return {
        ...state,
        points: []
      }
    default:
      return state
  }
}

export default mapReducer
