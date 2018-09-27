import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css']
})
export class SearchUsersComponent implements OnInit {

  name: string;
  customers: Customer[];

  constructor(private dataService: CustomerService) { }

  ngOnInit() {
  }

  private searchCustomers() {
    this.dataService.getCustomersByName(this.name)
      .subscribe(customers => this.customers = customers);
  }

  onSubmit() {
    this.searchCustomers();
  }

}
