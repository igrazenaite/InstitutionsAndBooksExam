import React from 'react';
import InstitutionComponent from './InstitutionComponent';

var InstitutionTableComponent =(props)=>{

    var allInstitutions = props.allInstitutions;
    if (allInstitutions.length===0){
        return <div>all institutions from server</div>
    } else {
        var institutionDrawing = allInstitutions.map((institution)=>{
            return <InstitutionComponent key={institution.institutionName} singleInstitution={institution}/>
        })
        return <tr>
                    {institutionDrawing}
               </tr>
    }
};
export default InstitutionTableComponent;
    
