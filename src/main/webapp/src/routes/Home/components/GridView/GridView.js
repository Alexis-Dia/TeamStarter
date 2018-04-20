import React, { Component } from 'react'
import { connect } from 'react-redux'
import './GridView.scss'
import LoadingBar from 'react-redux-loading-bar'

class GridView extends Component {

  constructor (props) {
    super(props)
    this.state = {
      gridData: null,
    }
  }

  componentWillReceiveProps (nextProps) {
    this.setState({gridData: nextProps.gridArr});
  }

  componentWillMount () {
    this.props.onGetData({numberOfElements: 4});
  }

  componentWillUnmount () {
    console.log("componentWillUnmount()");
  }

  shouldComponentUpdate () {
    console.log("shouldComponentUpdate()");
    return true;
  }

  componentWillUpdate () {
    console.log("componentWillUpdate()");
  }

  componentDidUpdate () {
    console.log("componentDidUpdate()");
  }

  increment = () => {
    //this.i = this.i + 1;
    console.log("componentWillReceiveProps() increment ");
    this.props.onGetData({numberOfElements: 12});
  }

  decrement = () => {
    console.log("componentWillReceiveProps() decrement ");
    this.props.onGetData({numberOfElements: 8});
  }

  render = () => {
    return (
      <div>
        <div className='grid-container1'>
          <button onClick={this.decrement}>-</button>
          <button onClick={this.increment}>+</button>
        </div>
        <div className='grid-container2'>
          <LoadingBar style={{ width: '60%'}} />
        </div>
        <div className='grid-grid' onLoad={this.loadTrigger}>
          {this.state.gridData !== null && (this.state.gridData.map((ob) =>
            <div className='gridChildren-grid' key={ob.name.first.toString() + ob.name.last.toString()}>
              <img src = {ob.picture.large} style={{ width: '70%' }}/>
              <div>{ob.name.first}</div>
            </div>
          ))}
        </div>
      </div>
    )
  }
}

const mapStateToProps = (state, ownProps) => {
  return {
    gridArr: state.gridData.points
  }
}

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onGetData: (data) => dispatch({ type: 'MAP_FETCH_MAIN_GRID', data })
  }
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(GridView);

