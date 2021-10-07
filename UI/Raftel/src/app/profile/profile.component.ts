import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public userId= -1;
  public user: any;
  public name='';

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    //this.route.paramMap.subscribe((params: ParamMap)=> this.userId= parseInt(params.get("id") || '-1'));
    this.userId= parseInt(sessionStorage.getItem('userId') || '-1');
    this.userService.getUser(this.userId).subscribe(data=>{
      this.user=data;
      console.log(this.user);
    });
    this.name=sessionStorage.getItem('name') || '';
  }

  test(){
    this.userService.test().subscribe(data=> console.log(data));
    this.router.navigate(['/all-orders']);
  }

}
