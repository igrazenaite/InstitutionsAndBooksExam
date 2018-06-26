import { Route, Switch } from 'react-router-dom';
import React, { Component } from 'react';
import InstitutionTableContainer from './Institutions/InstitutionTableContainer';
import BookTableContainer from './Books/BookTableContainer';
import InstitutionInfoContainer from './Institutions/InstitutionInfoContainer';
import NewInstitutionForm from './Institutions/NewInstitutionForm';
import NewBookForm from './Books/NewBookForm';
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
                    <Route path="/books" component={BookTableContainer}/>
                    <Route path="/singleInstitution/:institutionId" component={InstitutionInfoContainer}/>
                    <Route path="/newInstitution" component={NewInstitutionForm}/>
                    <Route path="/newBook" component={NewBookForm}/>
                    {/*<Route path="/newAssignation" component={NewAssignation}/>
                    <Route path="/singleInstitution/:institutionId" component={UpdateInstitution}/>
                    <Route path="/singleBook/:bookId" component={UpdateBook}/>
                    <Route path="/singleAssignation/update/:assignationId" component={AssignBookToInstitution}/> */}
                </Switch>    
            </main>
        )
    }
}export default Navigation;