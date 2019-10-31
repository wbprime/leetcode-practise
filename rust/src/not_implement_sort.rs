use crate::sort::Sort;

pub struct NotImplementSort {

}

impl NotImplementSort {
    pub fn new() -> NotImplementSort {
        NotImplementSort {}
    }
}

impl Sort for NotImplementSort {
    fn sort(&self, _data: &mut [i32]) {
        // Do nothing
    }
}
