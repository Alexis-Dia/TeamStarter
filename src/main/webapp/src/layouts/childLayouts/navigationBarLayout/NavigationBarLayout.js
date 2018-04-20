import React, { Component } from 'react'
import { Link } from 'react-router';
import { connect } from 'react-redux';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

import setAuthorizationToken from '../../../utils/setAuthorizationToken';
import setCurrentUser from '../../../utils/setCurrentUser';
import SignUpForm from './signUp/SignUpForm'
import LogInForm from './logIn/LoginForm'

class NavigationBarLayout extends Component {

    constructor(props) {
        super(props);
        this.state = {
            modalSignUp: false,
            modalLogIn: false
        };
    }

    logout = () => {
        this.props.logout();
        this.props.deleteAllFlashMessages();
    }

    toggleSignUp = () =>  {
        this.setState({
            modalSignUp: !this.state.modalSignUp
        });
    }

    toggleLogIn = () =>  {
        this.setState({
            modalLogIn: !this.state.modalLogIn
        });
    }

    render = () => {

        const { isAuthenticated } = this.props.auth;

        const userLinks = (
            <ul className="nav navbar-nav navbar-right">
                <li><a href="#" onClick={this.logout}>Logout</a></li>
            </ul>
        );

        const guestLinks = (
            <ul className="nav navbar-nav navbar-right">
                <li><Link onClick={this.toggleSignUp}>Sign up</Link></li>
                <li><Link onClick={this.toggleLogIn}>Login</Link></li>
            </ul>
        );

        return (
            <div className="navigatibBarMainStyles">
            <nav className="navbar navbar-default">
                <div className="container-fluid">
                    <div className="navbar-header">
                        <Link to="/" className="navbar-brand">Your awesome service!</Link>
                    </div>

                    <div className="collapse navbar-collapse">
                        { isAuthenticated ? userLinks : guestLinks }
                    </div>
                </div>
            </nav>
                <Modal isOpen={this.state.modalSignUp} toggle={this.toggleSignUp} className={this.props.className}>
                    {/*<ModalHeader toggle={this.toggle}>Modal title</ModalHeader>*/}
                    <ModalBody>
                        <SignUpForm toogle={this.toggleSignUp}/>
                    </ModalBody>
                    {/*<ModalFooter>
                        <Button color="primary" onClick={this.toggle}>Do Something</Button>{' '}
                        <Button color="secondary" onClick={this.toggle}>Cancel</Button>
                    </ModalFooter>*/}
                </Modal>

                <Modal isOpen={this.state.modalLogIn} toggle={this.toggleLogIn} className={this.props.className}>
                    <ModalBody>
                        <LogInForm toggleLogIn={this.toggleLogIn}/>
                    </ModalBody>
                </Modal>
            </div>
        );
    }
}

/*NavigationBarLayout.propTypes = {
    auth: React.PropTypes.object.isRequired,
/!*    logout: React.PropTypes.func.isRequired*!/
}*/

function mapStateToProps(state) {
    return {
        auth: state.auth
    };
}

const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        deleteAllFlashMessages: (data) => dispatch({type: 'DELETE_ALL_FLASH_MESSAGES', data}),
        logout: (data) => dispatch({type: 'DELETE_CURRENT_USER', data}),
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(NavigationBarLayout);