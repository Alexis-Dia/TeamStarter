import { MAP_FETCH_GOLOS_BLOG } from './golosDataActions'

const blogReducer = (state = {}, action) => {
  switch (action.type) {
    case MAP_FETCH_GOLOS_BLOG + '_SUCCESS':
      console.log('1', action)
      return {
        posts: action.response
      }
    case MAP_FETCH_GOLOS_BLOG + '_FAILURE':
      console.log('2', action)
      return {
        posts: []
      }
    default:
      return state
  }
}

export default blogReducer
