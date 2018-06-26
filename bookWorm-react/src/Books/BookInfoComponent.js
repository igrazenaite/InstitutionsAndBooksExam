import React, {Component} from 'react';
//import plant from '../Habenaria_radiata.jpg';

class BookInfoComponent extends Component{
  
    render(){
      return(
        <div className="caption">
          {/* <p>Paveiksliukas: {this.props.book.bookPhoto}</p> */}
          <p>Pavadinimas: {this.props.book.bookName}</p>
          <p>Autorius: {this.props.book.author}</p>
          <p>Puslapių skaičius: {this.props.book.numberOfPages}</p>
        </div>
        );
    }
  };

export default BookInfoComponent;