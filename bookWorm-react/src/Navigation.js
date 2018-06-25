import { Route, Switch } from 'react-router-dom';
import React, { Component } from 'react';
//import NewInstitutionRegistration from './Institutions/NewInstitutionRegistration';
import InstitutionTableContainer from './Institutions/InstitutionTableContainer';
//import NewBookRegistration from './Books/NewBookRegistration';
//import NewAssignation from './Assignation/NewAssignation';
//import UpdateInstitution from './Institution/UpdateInstitution';
//import UpdateBook from './Books/UpdateBook';
//import AssignBookToInstitution from './Assigantion/AssignBookToInstitution'


class Navigation extends Component{
    render(){
        return(
            <main>
                <Switch>
                    <Route path="/institutions" component={InstitutionTableContainer}/>
                    {/* <Route path="/newInstitution" component={NewInstitutionRegistration}/>
                    <Route path="/newBook" component={NewBookRegistration}/>
                    <Route path="/newAssignation" component={NewAssignation}/>
                    <Route path="/singleInstitution/:institutionId" component={UpdateInstitution}/>
                    <Route path="/singleBook/:bookId" component={UpdateBook}/>
                    <Route path="/singleAssignation/update/:assignationId" component={AssignBookToInstitution}/> */}
                </Switch>    
            </main>
        )
    }
}export default Navigation;