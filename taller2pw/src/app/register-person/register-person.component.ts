import {Component, ElementRef, HostListener, OnInit} from '@angular/core';
import {Person} from '../model/model.person';
import {UsersService} from '../users.service';
import {Router} from '@angular/router';
import {MapService} from '../map.service';
import {CatalogGF} from '../model/model.catalogGF';

@Component({
  selector: 'app-register-person',
  templateUrl: './register-person.component.html',
  styleUrls: ['./register-person.component.css']
})
export class RegisterPersonComponent implements OnInit {

  person: Person = new Person();
  catalogGF: CatalogGF = new CatalogGF();
  errorMessage: string;
  responseData: any;
  validationListG: any;
  validationListF: any;
  itemsGender: any[];
  itemsFrom: any[];

  constructor(public accountService: UsersService, public router: Router,
              private el: ElementRef, private service: MapService) {

  }

  ngOnInit() {
    this.person.gender = '';
    this.catalogGF.id_father = 4;
    this.service.getFrom(this.catalogGF.id_father).then((data) => {
      this.validationListF = JSON.parse(JSON.stringify(data)).response;
      this.itemsFrom = this.validationListF;
      console.log(this.validationListF);
    });

    this.catalogGF.id_father = 1;
    let proG = this.service.getGender(this.catalogGF.id_father);
    Promise.resolve(proG).then(data => {
      this.validationListG = JSON.parse(JSON.stringify(data)).response;
      this.itemsGender = this.validationListG;
    });

  }

  register(){
    //Preguntamos si la cedula consta de 10 digitos
    if(this.person.cedula.length == 10){
      //Obtenemos el digito de la region que son los dos primeros digitos
      let digito_region : any = this.person.cedula.substring(0,2);
        //Pregunto si la region existe ecuador se divide en 24 regiones
        if(digito_region >= 1 && digito_region <= 24){
          // Extraigo el ultimo digito
          let ultimo_digito   = this.person.cedula.substring(9,10);
          //Agrupo todos los pares y los sumo
          let pares = parseInt(this.person.cedula.substring(1,2)) + parseInt(this.person.cedula.substring(3,4)) + parseInt(this.person.cedula.substring(5,6)) + parseInt(this.person.cedula.substring(7,8));
          //Agrupo los impares, los multiplico por un factor de 2, si la resultante es > que 9 le restamos el 9 a la resultante
          let numero1 : any = this.person.cedula.substring(0,1);
          numero1 = (numero1 * 2);
          if( numero1 > 9 ){ numero1 = (numero1 - 9); } let numero3 : any = this.person.cedula.substring(2,3); numero3 = (numero3 * 2);
          if( numero3 > 9 ){ numero3 = (numero3 - 9); } let numero5 : any = this.person.cedula.substring(4,5); numero5 = (numero5 * 2);
          if( numero5 > 9 ){ numero5 = (numero5 - 9); } let numero7 : any = this.person.cedula.substring(6,7); numero7 = (numero7 * 2);
          if( numero7 > 9 ){ numero7 = (numero7 - 9); } let numero9 : any = this.person.cedula.substring(8,9); numero9 = (numero9 * 2);
          if( numero9 > 9 ){ numero9 = (numero9 - 9); } let impares = numero1 + numero3 + numero5 + numero7 + numero9;
          //Suma total
          let suma_total = (pares + impares);
          //extraemos el primero digito
          let primer_digito_suma = String(suma_total).substring(0,1);
          //Obtenemos la decena inmediata
          let decena = (parseInt(primer_digito_suma) + 1)  * 10;
          //Obtenemos la resta de la decena inmediata - la suma_total esto nos da el digito validador
          let digito_validador : any = decena - suma_total;
          //Si el digito validador es = a 10 toma el valor de 0
          if(digito_validador == 10)
              digito_validador = 0;
          //Validamos que el digito validador sea igual al de la cedula
          if(digito_validador == ultimo_digito){
            console.log('la cedula:' + this.person.cedula + ' es correcta');
            this.accountService.createAccountPerson(this.person).subscribe(data => {
              this.responseData = data;
              console.log(this.responseData);
              this.router.navigate(['/nav']);
            }, err => {
              console.log(err);
              this.errorMessage = "Already exist";
            });
          }else{
            console.log('la cedula:' + this.person.cedula + ' es incorrecta');
            alert('la cedula:' + this.person.cedula + ' es incorrecta')
          }
        }else{
          // imprimimos en consola si la region no pertenece
          console.log('Esta cedula no pertenece a ninguna region');
        }
    }else{
      //imprimimos en consola si la cedula tiene mas o menos de 10 digitos
      console.log('Esta cedula tiene menos de 10 Digitos');
    }
  }

}
