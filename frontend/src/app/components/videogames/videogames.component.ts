import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { find, Observable } from 'rxjs';
import { Videogame } from 'src/app/models/videogame.model';
import { VideogamesService } from 'src/app/services/videogames.service'; 

@Component({
  selector: 'app-videogames',
  templateUrl: './videogames.component.html',
  styleUrls: ['./videogames.component.css']
})
export class VideogamesComponent implements OnInit {
  
  videogames: Array<Videogame> = [];
  name = '';
  videogame: any;


  constructor(private videogamesService: VideogamesService, private router: Router,  private activatedRoute: ActivatedRoute) { }
   

  ngOnInit(): void  {
    
    // this.videogamesService.findGame(this.name).subscribe((dataResult: any) => {
    //   this.videogame = dataResult;
    //   console.log(this.videogame);
    // });
  }

findGame(): void {


  console.log('Im looking for ' + this.name);

  this.videogamesService.findGame(this.name).subscribe((dataResult: any) => {
    console.log(dataResult);
    this.videogame = dataResult;

  });
}
  
  //   this.videogamesService.findGame(videogameName:string).subscribe((dataResult: any) => {
  //   this.videogamesService = dataResult;
  // });
// }


//   findGame(name:string): Observable<any> {
//     return this.videogamesService.findGame(this.name).subscribe((dataResult: any) => {
//       this.videogame = dataResult;
//     });

// }
}
