import { Pipe, PipeTransform } from '@angular/core';
import { Player } from '../models/player';

@Pipe({
  name: 'filterPipe'
})
export class FilterPipePipe implements PipeTransform {

  transform(value: Player[], filterText: string): Player[] {
    filterText = filterText?filterText.toLocaleLowerCase():"" //filterText varsa kucuk harfe donustur yoksa bi şey yapma
    //filterText varsa value Playeri filterele ve yeni arraya atar.
    //her bi playeri ismini kucuk harfe donustur index of ile filtertext içindeki aranır. yoksa -1 dondurur o yüzden !==
    //filter ifadesi yoksa aynen value dondur.
    return filterText?value.filter((p :Player)=> p.name.toLocaleLowerCase().indexOf(filterText)!==-1):value;
  }

}
