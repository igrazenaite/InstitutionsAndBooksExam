import React from 'react';
import InstitutionComponent from './InstitutionComponent';


var InstitutionTableComponent =(props)=>{

    var allInstitutions = props.allInstitutions;
    if (allInstitutions.length===0){
        return <div>All institutions from server</div>
    } else {
        var institutionDrawing = allInstitutions.map((institution)=>{
            console.log("instid ", institution.institutionId);
            return <InstitutionComponent key={institution.institutionName} singleInstitution={institution}/>
        })
        return <div class="container">
                    <table class="table table-bordered">
                        <tr>
                            <th>Institucijos pavadinimas</th>
                            <th>Miestas</th>
                            <th>Kategorija</th>
                            <th>Tipas</th>
                            <th>Subkategorija</th>
                            <th>Daugiau</th>
                        </tr>
                            {institutionDrawing}
                    </table>
                </div>
    }
};
export default InstitutionTableComponent;
    
