import React from 'react'
import { IndexLink, Link } from 'react-router'
import PropTypes from 'prop-types'
import './PageLayout.scss'

import NavigationBarLayout from '../childLayouts/navigationBarLayout/NavigationBarLayout';
import FlashMessagestList from '../childLayouts/flashMessageLayout/FlashMessageListLayout';

export const PageLayout = ({ children }) => (
  <div className='container text-center'>
    <div className='page-layout__viewport'>
      <NavigationBarLayout />
      <FlashMessagestList />
        { children }
    </div>
  </div>
)

PageLayout.propTypes = {
  children: PropTypes.node,
}

export default PageLayout
