// Select all letters
const letters = document.querySelectorAll('.letter');

// Loop through each letter and apply the animation
letters.forEach((letter, index) => {
  letter.style.animationDelay = `${index * 0.1}s`; // Delay for each letter
  letter.style.opacity = 1; // Set the opacity to 1 to start the animation
});


// const images = document.querySelectorAll('.projectImg img');
// let currentIndex = 0;
// const imageCount = images.length;

// function cycleImages() {
//   images.forEach((img, index) => {
//     img.classList.remove('active');
//     // Adjust currentIndex to ensure cycling through images
//     const imagePosition = ((currentIndex + index) % imageCount);
//     if (imagePosition === Math.floor(imageCount / 2)) {
//       img.classList.add('active'); // Center image becomes large
//     }
//   });
//   currentIndex++;
// }

// setInterval(cycleImages, 2000); // Change every 2 seconds


// const projectImg = document.querySelector('.projectImg');

// // Duplicate the content for seamless infinite scrolling
// const images = document.querySelectorAll('.projectImg .inlineBlock');
// const totalImages = images.length;
// const cloneFirst = images[0].cloneNode(true);
// projectImg.appendChild(cloneFirst);

// projectImg.addEventListener('scroll', () => {
//   const scrollLeft = projectImg.scrollLeft;
//   const maxScrollLeft = projectImg.scrollWidth - projectImg.clientWidth;

//   // When the user scrolls to the end, reset to the first image
//   if (scrollLeft >= maxScrollLeft) {
//     projectImg.scrollLeft = 0; // Reset scroll position to the start
//   }
// });


const projectImg = document.querySelector('.projectImg');
const imagesContainer = document.querySelector('.projectImg'); // The container holding the images
let images = document.querySelectorAll('.inlineBlock'); // Query all the image containers

// Function to center a specific image smoothly
function centerImage(index) {
  const imageToCenter = images[index];
  const imageWidth = imageToCenter.clientWidth;
  const containerWidth = projectImg.clientWidth;
  const imageOffset = imageToCenter.offsetLeft;

  // Calculate the scroll position to center the image
  const scrollPosition = imageOffset - (containerWidth / 2) + (imageWidth / 2);

  // Smooth scrolling to the calculated position
  projectImg.scrollTo({
    left: scrollPosition,
    behavior: 'smooth'
  });
}

// Center the third image when the page loads
window.addEventListener('load', () => {
  centerImage(2); // Third image (0-based index)
});

// Function to find the closest image to the center
function getClosestImageToCenter() {
  const containerWidth = projectImg.clientWidth;
  const center = projectImg.scrollLeft + (containerWidth / 2);

  let closestIndex = 0;
  let minDistance = Infinity;

  images.forEach((image, index) => {
    const imageCenter = image.offsetLeft + (image.clientWidth / 2);
    const distance = Math.abs(center - imageCenter);

    if (distance < minDistance) {
      minDistance = distance;
      closestIndex = index;
    }
  });

  return closestIndex;
}

let autoScroll = function() {

  setTimeout(() => {
    projectImg.scrollLeft += 500;
  },200)

}

let setsedIndex=document.querySelector('.img1');
let setsedIndex2=document.querySelector('.img1');
function activeImg(index) {
  let currentIndexImg = index+1;
  console.log('.img'+currentIndexImg)
  const activeI = images[index];
console.log('.I' + parseInt(activeI.id));
  activeI.classList.add('activeImgDiv');
  const activeI2 = document.querySelector('.img'+parseInt(activeI.id));
  activeI2.classList.add('activeImg');
  setsedIndex=activeI;
  setsedIndex2=activeI2;
}


// Function to snap to the closest image when scrolling stops
let isScrolling;
projectImg.addEventListener('scroll', () => {
  clearTimeout(isScrolling);
  console.log(setsedIndex)
if (setsedIndex.classList.contains('activeImgDiv') && setsedIndex2.classList.contains('activeImg')) {
    setsedIndex.classList.remove('activeImgDiv');
    setsedIndex2.classList.remove('activeImg');
}

  isScrolling = setTimeout(() => {
    const closestImageIndex = getClosestImageToCenter();
    centerImage(closestImageIndex); // Smooth snapping to the closest image
  // setTimeout(() => {
  //       projectImg.scrollTo({
  //           left: projectImg.scrollLeft + (images[closestImageIndex].clientWidth-100), // Scroll 400 pixels to the right
  //           behavior: 'smooth' // Smooth scrolling behavior
  //       });
  // },3500)
  activeImg(closestImageIndex);
    }, 200 ); // Delay before snapping after scrolling stops

  const scrollLeft = projectImg.scrollLeft;
  const maxScrollLeft = projectImg.scrollWidth - projectImg.clientWidth;

  // Scrolling to the right (reaching the end)
  if (scrollLeft >= maxScrollLeft - 1) { // Slight buffer for smoothness
    const firstImage = images[0]; // Store the first image
    imagesContainer.appendChild(firstImage); // Move the first image to the end
    projectImg.scrollLeft -= firstImage.clientWidth; // Adjust the scroll position to maintain the flow
  }

  // Scrolling to the left (reaching the beginning)
  if (scrollLeft <= 0) { // If scrolled all the way to the left
    const lastImage = images[images.length - 1]; // Store the last image
    imagesContainer.prepend(lastImage); // Move the last image to the front
    projectImg.scrollLeft += lastImage.clientWidth; // Adjust the scroll position to maintain the flow
  }

  // Requery the images after modification to reflect the new order
  images = document.querySelectorAll('.inlineBlock'); // Update the images NodeList





});

  // autoScroll(){
  // }


