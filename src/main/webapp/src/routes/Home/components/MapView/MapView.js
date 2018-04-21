import React, { Component } from 'react'
import Gm from './Gm'
import './MapView.scss'
import { connect } from 'react-redux'
import { Link } from 'react-router'

class HomeView extends Component {
  constructor (props) {
    super(props)
    this.state = {
      active: null,
    }
  }

  handleMarkerClick = (index) => {
    this.setState({ active: index })
  }

  handleDelete = () => {
    if (this.state.active === null) { return }
    const points = this.state.points.slice()
    points.splice(this.state.active, 1)
    this.setState({ active: null, points })
    this.props.delete(this.state.points[this.state.active].id)
  }

  handleBoundsChanged = () => {
    const bounds = this.map.getBounds()
    const minLat = bounds.getSouthWest().lat()
    const minLng = bounds.getSouthWest().lng()
    const maxLat = bounds.getNorthEast().lat()
    const maxLng = bounds.getNorthEast().lng()

    const params = { minLat, minLng, maxLat, maxLng }

    if (this.state.fetch) {
      clearTimeout(this.state.fetch)
    }
    this.fetch(params)
    // this.setState({
    //   // fetch: setTimeout(() => {
    //   //   this.fetch(params)
    //   // }, 200)
    //   333: this.fetch(params)
    // })
  }

  componentWillMount() {
  }

  componentWillReceiveProps (nextprops) {
    if (nextprops.mapData !== this.props.mapData && Array.isArray(this.props.mapData)) {
      this.setState({ points: nextprops.mapData })
    }
  }

  seed = () => {
    const bounds = this.map.getBounds()
    const latitude = bounds.getCenter().lat()
    const longitude = bounds.getCenter().lng()
    this.props.seed({ latitude, longitude })
  }

  fetch = (params) => {
    this.props.fetch(params || {
      minLat: 59.3001454302915,
      maxLat: 59.5001454302915,
      minLng: 18.0052783802915,
      maxLng: 18.1652783802915
    })
    this.setState({ active: null })
  }

  increment = () => {
    this.props.onGetData(['alexeyd', 5, 5])
  }

  render = () => {
    const { points } = this.state
    return (
      <div>
        <div className='map-container1'>

          <div>
            <div className='map-container2'>
              <div className='map-container3'>
                <div className='marker-details'>
                  {this.state.active !== null && (
                    <div className='map-container4'>
                      <div className='map-container5'>
                        <h4>{points[this.state.active].name}</h4>
                      </div>
                      </div>
                  )}
                </div>
              </div>
            </div>
          </div>

          <div className='marker-details'>
            {this.state.active !== null && (
              <div>
{/*                <div className='lat'>lat: {points[this.state.active].geometry.location.lat}</div>
                <div className='lng'>lng: {points[this.state.active].geometry.location.lng}</div>
                <div className='text'>{points[this.state.active].name}</div>
                <button onClick={this.handleDelete}>delete</button>*/}
              </div>
            )}
          </div>
        </div>
        <Gm
          googleMapURL='https://maps.googleapis.com/maps/api/js?key=AIzaSyCORkSPlFW2YmZcr_hiuLeal8U-TDuAYrs&
          v=3.exp&libraries=geometry,drawing,place'
          loadingElement={<div style={{ height: `100%` }} />}
          containerElement={<div style={{ height: `400px` }} />}
          mapElement={<div style={{ height: `100%` }} />}
          data={this.state.points}
          handleMarkerClick={this.handleMarkerClick}
          onMapMounted={ref => { this.map = ref }}
          onBoundsChanged={this.handleBoundsChanged}
        />
      </div>
    )
  }
}

const mapStateToProps = (state, ownProps) => {
  return {
    mapData: state.mapData.points || {}
  }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    fetch: (data) => dispatch({ type: 'MAP_FETCH', data }),
    seed: (data) => dispatch({ type: 'MAP_SEED', data }),
    delete: (id) => dispatch({ type: 'MAP_DELETE_POINT', id })
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(HomeView)
