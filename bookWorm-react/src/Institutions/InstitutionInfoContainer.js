import React, {Component} from 'react';
import InstitutionInfoComponent from './InstitutionInfoComponent';
import axios from 'axios';

class InstitutionInfoContainer extends Component{
  

    //get institution info
    componentWillMount=(institutionId)=>{
        axios.get("http://localhost:8081/singleInstitution/"+institutionId)
        .then((response)=>{
            this.setState({institutionInfo: response.data});
        })
        .catch((error)=>{
            console.log(error);
        });  
    }


    render (){
        console.log("id ", this.institutionId);
        console.log("info ", this.institutionInfo);
        return (
        <div>
            <InstitutionInfoComponent singleInstitutionInfo={this.props.institutionInfo}/>
        </div>
      )
    }
}

export default InstitutionInfoContainer;