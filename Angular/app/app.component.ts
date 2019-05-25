import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'etoiles-project';

  ngOnInit() {
    var divcontenu = document.getElementsByName("contenu")[0].style.display = "none"
  }

}
