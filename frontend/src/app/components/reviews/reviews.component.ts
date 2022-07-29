import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Review } from 'src/app/models/review.model';
import { ReviewsService } from 'src/app/services/reviews.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
  reviews: Review;
  reviewList: Review[];
  rankingList: any[];


  constructor(
    private http: HttpClient,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private reviewsService: ReviewsService
  ) {

    this.reviews = new Review(0,'','',0,'');
    this.reviewList = [];
    this.rankingList = [];

   }
  
    ngOnInit(): void {
      this.reviewsService.ranking().subscribe((dataResult: any) => {
        this.rankingList = dataResult;
        console.log(this.rankingList)
      }
      );
    }

    onSubmit(){
      this.reviewsService.addReview(this.reviews).subscribe( (reviews) =>{
        this.reviewList.push(reviews);
        console.log(reviews);
        console.log(this.reviews);
        this.reviews = new Review(0,'','',0,'');
        
      });
    }


    
  }
