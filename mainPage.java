// Select all letters
const letters = document.querySelectorAll('.letter');

// Loop through each letter and apply the animation
letters.forEach((letter, index) => {
  letter.style.animationDelay = `${index * 0.1}s`; // Delay for each letter
  letter.style.opacity = 1; // Set the opacity to 1 to start the animation
});

 var userLanguage;

document.addEventListener("DOMContentLoaded", function() {
   userLanguage = navigator.language || navigator.userLanguage;
  const eng = document.getElementById('en');
  const ar = document.getElementById('ar');

    eng.addEventListener('click', function() {
      userLanguage = "en";
      console.log("User language set to English");
    });

    ar.addEventListener('click', function() {
      console.log("User language set to Arabic");
      userLanguage = "ar";
    });
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


window.addEventListener('scroll', function() {
    const header = document.querySelector('.header');
    if (window.scrollY > 50) {
        header.classList.add('scrolled');
    } else {
        header.classList.remove('scrolled');
    }
});



document.addEventListener("DOMContentLoaded", () => {
  const icons = document.querySelectorAll(".UVPrinterIconImG, .CNCIconImg, .JOINERVIconImg , .paintIconIMG ,.DesignerIconIMG ,.BlacksmithIconIMG ,.steckerIconIMG");

  const observer = new IntersectionObserver((entries, observer) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add("in-view"); // Add class when in view
      } else {
        entry.target.classList.remove("in-view"); // Remove class when out of view
      }
    });
  }, { threshold: 0.5 }); // Adjust as needed for when you want animation to trigger

  icons.forEach(icon => observer.observe(icon));
});


var closeBtn = document.getElementById('closeBtn');

closeBtn.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  popup.style.display = 'none';
});





var UVPrinterIconImG = document.querySelector('.UVPrinterIconImG');
var CNCIconImg = document.querySelector('.CNCIconImg');
var JOINERVIconImg = document.querySelector('.JOINERVIconImg');
var paintIconIMG = document.querySelector('.paintIconIMG');
var DesignerIconIMG = document.querySelector('.DesignerIconIMG');
var BlacksmithIconIMG = document.querySelector('.BlacksmithIconIMG');
var steckerIcon = document.querySelector('.steckerIcon');

let printTxt="Equipped with advanced printing technology, our Printing Department provides versatile services, from UV printing for vibrant, long-lasting colors to custom sticker printing for branding. We bring your ideas to life on a wide range of materials, offering high-quality, impactful prints for any purpose."
let CNCTxt="In the CNC Department, we specialize in precision cutting for materials like wood, foam, and plastics. Our expert operators and top-tier machinery ensure accurate and intricate designs, enabling us to create custom pieces that enhance any display or promotional setup. "
let JOINERVTxt="Our Joinery Department focuses on crafting custom, high-quality woodwork. From booths and stands to unique display setups, our joiners create sturdy, stylish pieces that are integral to our advertising installations. Their expertise ensures each project is finished with an eye for detail and durability."
let paintTxt="The Paint Department provides finishing touches that bring our projects to life. Using a range of colors and finishes, our skilled painters add vibrancy and protection, enhancing both the visual appeal and longevity of every piece we produce."
let DesignerTxt="Our Design Department brings creativity and innovation to every project. Skilled in 3D Max, Photoshop, and Illustrator, our designers create stunning visuals that form the foundation of our physical displays, ensuring that each project is eye-catching, functional, and aligned with our clients' vision."
let BlacksmithTxt="The Blacksmith Department combines traditional skills with modern techniques to deliver durable, custom-made metalwork. Whether it’s sturdy frames for displays, unique decorative elements, or robust stands, our blacksmith team ensures precision and resilience in every project."
let steckerTxt="Our Sticker Department is dedicated to crafting high-quality stickers that meet the specific needs of our clients. From eye-catching decals to branding essentials, we handle the full process, including LED integration and meticulous collection and finishing touches. Our stickers are designed to last, with options that suit indoor and outdoor applications."

let printTitle="Printing Department"
let CNCTitle="CNC Department"
let JOINERTitle="Joinery Department"
let paintTitle="Paint Department"
let DesignerTitle="Designer Department"
let BlacksmithTitle="Blacksmith Department"
let steckerTitle="Sticker Department"



 function updateLang()  { 
  if(userLanguage == 'ar'){
   printTxt="يتميز قسم الطباعة بتقنيات طباعة متقدمة، مما يتيح لنا تقديم خدمات متنوعة، مثل الطباعة بالأشعة فوق البنفسجية للحصول على ألوان نابضة بالحياة تدوم طويلاً، إلى جانب طباعة الملصقات المخصصة للعلامات التجارية. نحن نحول أفكارك إلى واقع على مجموعة واسعة من المواد بجودة عالية وأثر بصري قوي."
 CNCTxt="يتخصص قسم سي إن سي لدينا في قطع المواد بدقة، مثل الخشب والرغوة والبلاستيك. يضمن مشغلونا المهرة وآلاتنا عالية الجودة تصاميم دقيقة ومتقنة، مما يمكننا من إنشاء قطع مخصصة تضيف قيمة إلى أي عرض أو إعداد ترويجي."
 JOINERVTxt="يركز قسم النجارة على تصنيع الأعمال الخشبية المخصصة عالية الجودة. من الأكشاك إلى الهياكل المخصصة للعرض، يقوم فريقنا بإنتاج قطع متينة وأنيقة تندمج ضمن تجهيزات العرض والإعلانات. يضمن اهتمامهم بالتفاصيل تقديم مشاريع تتميز بالثبات والجمال."
 paintTxt="يقدم قسم الدهانات اللمسات النهائية التي تضفي الحياة على مشاريعنا. باستخدام مجموعة من الألوان والتشطيبات، يقوم فريقنا من الرسامين بإضافة الحيوية والحماية، مما يزيد من جاذبية وجمال وديمومة كل قطعة ننتجها."
 DesignerTxt="يتميز قسم التصميم لدينا بالإبداع والابتكار الذي يضفي لمسات فريدة على كل مشروع نقوم به. يعمل فريق التصميم باحترافية عالية لإنتاج تصاميم بصرية جذابة ومتميزة تشكل جوهر تجهيزات العرض وتضيف لمسات جمالية تتناسب مع رغبات وأهداف العملاء. نسعى دائماً لتحقيق التوازن بين الشكل والوظيفة، بحيث تكون كل قطعة ملفتة للنظر وفعّالة في الوقت ذاته، مما يضمن تحقيق رؤية العميل بشكل كامل واحترافي."
 BlacksmithTxt="يجمع قسم الحدادة بين المهارات التقليدية والتقنيات الحديثة لتقديم أعمال معدنية متينة ومخصصة. سواء كانت إطارات قوية للعرض أو عناصر زخرفية فريدة أو قواعد ثابتة، يضمن فريقنا من الحدادين الدقة والصلابة في كل مشروع."
 steckerTxt="يهتم قسم الملصقات لدينا بإنتاج ملصقات عالية الجودة تلبي احتياجات عملائنا بدقة. بدءًا من الملصقات المميزة إلى الملصقات المخصصة للعلامات التجارية، نتولى عملية الإنتاج بالكامل، بما في ذلك دمج الإضاءة ووضع اللمسات النهائية بعناية. صُممت ملصقاتنا لتدوم وتناسب الاستخدام الداخلي والخارجي."
 printTitle="قسم الطباعة";
 CNCTitle="قسم CNC";
 JOINERTitle="قسم النجارة";
 paintTitle="قسم الدهانات";
 DesignerTitle="قسم التصميم";
 BlacksmithTitle="قسم الحدادة";
 steckerTitle="قسم الملصقات";
} else {
 printTxt="Equipped with advanced printing technology, our Printing Department provides versatile services, from UV printing for vibrant, long-lasting colors to custom sticker printing for branding. We bring your ideas to life on a wide range of materials, offering high-quality, impactful prints for any purpose."
 CNCTxt="In the CNC Department, we specialize in precision cutting for materials like wood, foam, and plastics. Our expert operators and top-tier machinery ensure accurate and intricate designs, enabling us to create custom pieces that enhance any display or promotional setup. "
 JOINERVTxt="Our Joinery Department focuses on crafting custom, high-quality woodwork. From booths and stands to unique display setups, our joiners create sturdy, stylish pieces that are integral to our advertising installations. Their expertise ensures each project is finished with an eye for detail and durability."
 paintTxt="The Paint Department provides finishing touches that bring our projects to life. Using a range of colors and finishes, our skilled painters add vibrancy and protection, enhancing both the visual appeal and longevity of every piece we produce."
 DesignerTxt="Our Design Department brings creativity and innovation to every project. Skilled in 3D Max, Photoshop, and Illustrator, our designers create stunning visuals that form the foundation of our physical displays, ensuring that each project is eye-catching, functional, and aligned with our clients' vision."
 BlacksmithTxt="The Blacksmith Department combines traditional skills with modern techniques to deliver durable, custom-made metalwork. Whether it’s sturdy frames for displays, unique decorative elements, or robust stands, our blacksmith team ensures precision and resilience in every project."
 steckerTxt="Our Sticker Department is dedicated to crafting high-quality stickers that meet the specific needs of our clients. From eye-catching decals to branding essentials, we handle the full process, including LED integration and meticulous collection and finishing touches. Our stickers are designed to last, with options that suit indoor and outdoor applications."

 printTitle="Printing Department"
 CNCTitle="CNC Department"
 JOINERTitle="Joinery Department"
 paintTitle="Paint Department"
 DesignerTitle="Designer Department"
 BlacksmithTitle="Blacksmith Department"
 steckerTitle="Sticker Department"
}
 }



UVPrinterIconImG.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
  updateLang();
  departmentInfo__title.textContent = printTitle;
  
  body.innerHTML = `
    <img src="SC-V7000_01-headon_690x460.jpg" alt="" class="printIMG col-12">
    <p class="printingTXT">
    ${printTxt}
    </p>`;
  
  popup.style.display = 'flex';
});


CNCIconImg.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = CNCTitle;
  
  body.innerHTML = `
    <img src="1-15112R330080-L.jpg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${CNCTxt}
    </p>`;
  
  popup.style.display = 'flex';
});


JOINERVIconImg.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = JOINERTitle;
  
  body.innerHTML = `
    <img src="Joinery-Services-scaled.jpeg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${JOINERVTxt}
    </p>`;
  
  popup.style.display = 'flex';
});


paintIconIMG.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = paintTitle;
  
  body.innerHTML = `
    <img src="images.jpeg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${paintTxt}
    </p>`;
  
  popup.style.display = 'flex';
});


DesignerIconIMG.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = DesignerTitle;
  
  body.innerHTML = `
    <img src="2b29159cb43b168de59db340db81027f5f6cdd2b-migrating-from-3ds-max-to-cinema-4d-in-professional-arch-viz-part-1-1.jpg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${DesignerTxt}
    </p>`;
  
  popup.style.display = 'flex';
});



BlacksmithIconIMG.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = BlacksmithTitle;
  
  body.innerHTML = `
    <img src="Martin-Bustamante-12868647634_980d853d34_o-e1612362182502.jpg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${BlacksmithTxt}
    </p>`;
  
  popup.style.display = 'flex';
});



steckerIcon.addEventListener('click', function() {
  var popup = document.getElementById('departmentInfo');
  var departmentInfo__title = document.querySelector('.departmentInfo__title');
  var body = document.querySelector('.body');
    updateLang();
  departmentInfo__title.textContent = steckerTitle;
  
  body.innerHTML = `
    <img src="graphtec-fcx4000-60-es-flatbed-cutter-384-x-259-graphtec-bundle-graphtec-923947_2048x.jpg" alt="" class="printIMG col-12">
    <p class="printingTXT">
      ${steckerTxt}
    </p>`;
  
  popup.style.display = 'flex';
});
