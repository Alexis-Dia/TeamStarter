import { combineReducers } from 'redux'
import locationReducer from './location'
import mapReducer from '../api/map/mapReducer'
import gridReducer from '../api/map/gridReducer'
import authReducer from '../api/login/loginReducer'
import flashReducer from '../api/flash/flashReducer'
import signupReducer from '../api/signup/signupReducer'
import blogReducer from '../api/golosData/golosDataReducer'
import { loadingBarReducer } from 'react-redux-loading-bar'

export const makeRootReducer = (asyncReducers) => {
  return combineReducers({
    mapData: mapReducer,
    gridData: blogReducer,
    location: locationReducer,
    loadingBar: loadingBarReducer,
    auth: authReducer,
    flashMessages: flashReducer,
    newUser: signupReducer,
    ...asyncReducers
  })
}

export const injectReducer = (store, { key, reducer }) => {
  if (Object.hasOwnProperty.call(store.asyncReducers, key)) return

  store.asyncReducers[key] = reducer
  store.replaceReducer(makeRootReducer(store.asyncReducers))
}

export default makeRootReducer
