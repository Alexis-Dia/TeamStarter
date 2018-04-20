import React, { Component } from 'react'
import { Carousel } from 'react-responsive-carousel'
import './SliderView.scss'
import './carousel.scss'
import pic1 from './1.png'
import pic2 from './2.png'
import pic3 from './3.png'
import pic4 from './4.png'
import pic5 from './5.png'

export default class SliderView extends Component {

  render = () => {
    return (
      <div>
        <div>
          <Carousel showThumbs={false} showArrows={true} showStatus={false} >
            <div>
              <img src={pic1} />
              {/*<p className='legend'>Legend 2</p>*/}
            </div>
            <div>
              <img src={pic3} />
              {/*<p className='legend'>Legend 2</p>*/}
            </div>
            <div>
              <img src={pic4} />
              {/*<p className='legend'>Legend 2</p>*/}
            </div>
            <div>
              <img src={pic5} />
              {/*<p className='legend'>Legend 2</p>*/}
            </div>
            <div>
              <img src={pic2} />
              {/*<p className='legend'>Legend 1</p>*/}
            </div>
          </Carousel>
        </div>
      </div>
    )
  }

}
