// Select all letters
const letters = document.querySelectorAll('.letter');

// Loop through each letter and apply the animation
letters.forEach((letter, index) => {
  letter.style.animationDelay = `${index * 0.1}s`; // Delay for each letter
  letter.style.opacity = 1; // Set the opacity to 1 to start the animation
});
