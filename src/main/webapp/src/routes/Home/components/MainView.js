import React, { Component } from 'react'
import SliderView from './SliderView/SliderView'
import GridView from './GridView/GridView'
import MapView from './MapView/MapView'
import FooterView from './FooterView/FooterView'
import MenuView from './MenuView/MenuView'
import './MainView.scss'

export default class MainView extends Component {

  render = () => {
    return (
      <div>
        <div className='main-header'>
          <SliderView />
          <GridView />
          <MapView />
          <FooterView />
        </div>
      </div>
    )
  }

}
