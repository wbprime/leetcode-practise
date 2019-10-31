use rand::prelude::*;

use leetcode_practise::bubble_sort::BubbleSort;
use leetcode_practise::insert_sort::InsertSort;
use leetcode_practise::not_implement_sort::NotImplementSort;
use leetcode_practise::select_sort::SelectSort;
use leetcode_practise::sort::Sort;

fn main() {
    //    let mut data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    let mut rng = rand::thread_rng();

    {
        let mut data: Vec<i32> = (1..100).collect();
        data.shuffle(&mut rng);

        let sorting = NotImplementSort::new();

        println!("Before sorting: {:?}", data);
        sorting.sort(&mut data);
        println!("After sorting: {:?}", data);
    }
    {
        let mut data: Vec<i32> = (1..100).collect();
        data.shuffle(&mut rng);

        let sorting = BubbleSort::new();

        println!("Before sorting: {:?}", data);
        sorting.sort(&mut data);
        println!("After sorting: {:?}", data);
    }
    {
        let mut data: Vec<i32> = (1..100).collect();
        data.shuffle(&mut rng);

        let sorting = SelectSort::new();

        println!("Before sorting: {:?}", data);
        sorting.sort(&mut data);
        println!("After sorting: {:?}", data);
    }
    {
        let mut data: Vec<i32> = (1..100).collect();
        data.shuffle(&mut rng);

        let sorting = InsertSort::new();

        println!("Before sorting: {:?}", data);
        sorting.sort(&mut data);
        println!("After sorting: {:?}", data);
    }
}
