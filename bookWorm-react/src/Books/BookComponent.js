import React from 'react';
import '../Style/ComponentStyle.css'
import '../Style/Icons.css'

var BookComponent = (props)=>{
    var book = props.singleBook;
    return  <tr>
                {/* <td>{book.bookPhoto}</td> */}
                <td>{book.bookName}</td>
                <td>{book.author}</td>
                <td>{book.numberOfPages}</td>
                <td>    
                    <a href="#">
                        <span class="glyphicon glyphicon-info-sign" id="infoIcon"></span>
                    </a>
                    <a href="#">
                        <span class="glyphicon glyphicon-pencil" id="editIcon"></span>
                    </a>
                    <a href="#">
                        <span class="glyphicon glyphicon-trash" id="deleteIcon"></span>
                    </a>
                    {/* <button className="btn btn-primary">Daugiau</button> */}
                </td>
            </tr>

}

export default BookComponent;