// Select all letters
const letters = document.querySelectorAll('.letter');

// Loop through each letter and apply the animation
letters.forEach((letter, index) => {
  letter.style.animationDelay = `${index * 0.1}s`; // Delay for each letter
  letter.style.opacity = 1; // Set the opacity to 1 to start the animation
});

 var userLanguage= "ar";

document.addEventListener("DOMContentLoaded", function() {
  //  userLanguage = navigator.language || navigator.userLanguage;
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
  const activeI = images[index];
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

let printTxt="يتميز قسم الطباعة بتقنيات طباعة متقدمة، مما يتيح لنا تقديم خدمات متنوعة، مثل الطباعة بالأشعة فوق البنفسجية للحصول على ألوان نابضة بالحياة تدوم طويلاً، إلى جانب طباعة الملصقات المخصصة للعلامات التجارية. نحن نحول أفكارك إلى واقع على مجموعة واسعة من المواد بجودة عالية وأثر بصري قوي."
let CNCTxt="يتخصص قسم سي إن سي لدينا في قطع المواد بدقة، مثل الخشب والرغوة والبلاستيك. يضمن مشغلونا المهرة وآلاتنا عالية الجودة تصاميم دقيقة ومتقنة، مما يمكننا من إنشاء قطع مخصصة تضيف قيمة إلى أي عرض أو إعداد ترويجي."
let JOINERVTxt="يركز قسم النجارة على تصنيع الأعمال الخشبية المخصصة عالية الجودة. من الأكشاك إلى الهياكل المخصصة للعرض، يقوم فريقنا بإنتاج قطع متينة وأنيقة تندمج ضمن تجهيزات العرض والإعلانات. يضمن اهتمامهم بالتفاصيل تقديم مشاريع تتميز بالثبات والجمال."
let paintTxt="يقدم قسم الدهانات اللمسات النهائية التي تضفي الحياة على مشاريعنا. باستخدام مجموعة من الألوان والتشطيبات، يقوم فريقنا من الرسامين بإضافة الحيوية والحماية، مما يزيد من جاذبية وجمال وديمومة كل قطعة ننتجها."
let DesignerTxt="يتميز قسم التصميم لدينا بالإبداع والابتكار الذي يضفي لمسات فريدة على كل مشروع نقوم به. يعمل فريق التصميم باحترافية عالية لإنتاج تصاميم بصرية جذابة ومتميزة تشكل جوهر تجهيزات العرض وتضيف لمسات جمالية تتناسب مع رغبات وأهداف العملاء. نسعى دائماً لتحقيق التوازن بين الشكل والوظيفة، بحيث تكون كل قطعة ملفتة للنظر وفعّالة في الوقت ذاته، مما يضمن تحقيق رؤية العميل بشكل كامل واحترافي."
let BlacksmithTxt="يجمع قسم الحدادة بين المهارات التقليدية والتقنيات الحديثة لتقديم أعمال معدنية متينة ومخصصة. سواء كانت إطارات قوية للعرض أو عناصر زخرفية فريدة أو قواعد ثابتة، يضمن فريقنا من الحدادين الدقة والصلابة في كل مشروع."
let steckerTxt="يهتم قسم الملصقات لدينا بإنتاج ملصقات عالية الجودة تلبي احتياجات عملائنا بدقة. بدءًا من الملصقات المميزة إلى الملصقات المخصصة للعلامات التجارية، نتولى عملية الإنتاج بالكامل، بما في ذلك دمج الإضاءة ووضع اللمسات النهائية بعناية. صُممت ملصقاتنا لتدوم وتناسب الاستخدام الداخلي والخارجي."
let printTitle="قسم الطباعة";
let CNCTitle="قسم CNC";
let JOINERTitle="قسم النجارة";
let paintTitle="قسم الدهانات";
let DesignerTitle="قسم التصميم";
let BlacksmithTitle="قسم الحدادة";
let steckerTitle="قسم الملصقات";



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

var chatHistory = "";
let messagecounter=0;
const chatBack=document.getElementById('chatBack');
const robotImg=document.querySelector('.robotImg');


robotImg.addEventListener('click', function() {
  chatBack.style.display = 'flex';
});





// Listen for Enter key press
const chatTxt = document.getElementById('chatTxt');
chatTxt.addEventListener('keydown', function(event) {
  if (event.key === 'Enter') {
    sendMesg(chatTxt.value); // Pass the message content
    chatTxt.value = ''; // Clear the input field after sending
  }
});

// Send message to OpenAI API using fetch
async function sendMesg(chatMesg) {
  const apiKey = "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"; // Replace with your API key
  const apiUrl = "https://api.openai.com/v1/chat/completions";


  chatHistory+=("message hestory "+messagecounter+" {role: 'user', content: "+chatMesg+"}");
  messagecounter++;
  const data = {
    model: "gpt-4",
    messages: [
      { role: "system", content: "what dose the user asking about choose between the following options: 1. a normal qustion 2. image generation    >>Note:the response must be in this format: 1 or 2" },
      { role: "user", content: chatHistory }
    ]
  };

  generateChatContainerUser(chatMesg);
  TypingMessage();


  try {
    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${apiKey}`
      },
      body: JSON.stringify(data)
    });

    if (response.ok) {
      const result = await response.json();
      const aiResponse = result.choices[0].message.content;
      if(aiResponse.includes("2")){
        const imageUrl = await generateImage(chatMesg);
        // displayMessage(imageUrl);
        return;
      } else{
      sendCompletionMesage(chatMesg); // Call a function to display the AI's response
      }

    } else {
      console.error("API request failed:", response.status, response.statusText);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

// Display the AI's response in the chat window



async function generateImage(imageTxt) {
  const apiKey = "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"; // Replace with your actual API key
  const apiUrl = "https://api.openai.com/v1/images/generations";


  const data = {
    model: "dall-e-3",
    prompt: chatHistory,
    n: 1,
    size: "1024x1024"
  };

  try {
    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${apiKey}`
      },
      body: JSON.stringify(data)
    });

    if (response.ok) {
      const result = await response.json();
      const imageUrl = result.data[0].url; // The URL for the generated image
      displayImage(imageUrl); // Function to display the generated image
      // chatHistory.push({ role: "assistant", content: imageUrl });
      chatHistory+=("message hestory "+messagecounter+" {role: 'assistant', content: "+imageUrl+"}");
    } else {
      console.error("API request failed:", response.status, response.statusText);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

// Function to display the image on the webpage
function displayImage(imageUrl) {
  const chatTxt= document.getElementById('chatTxt');
  chatTxt.disabled=false;
  const TypingMessage = document.querySelector('.TypingMessage');
  TypingMessage.remove();
    // const imageContainer = document.getElementById('imageContainer'); 
    const chatContainer = document.createElement('div');
  chatContainer.classList.add('chatContainerTxt');
  const chatBody = document.querySelector('.chatBody');
  // const imageDis= document.createElement('img');
  const img = document.createElement('img');
  img.src = imageUrl;
  img.alt = "Generated image";
  img.style.width = "100%";
  img.classList.add('generatedImageStyle');
  chatContainer.appendChild(img);
  chatBody.appendChild(chatContainer);
  const element = document.querySelector(".chatBody");
  element.scrollTo({ top: element.scrollHeight, behavior: "smooth" });
}


// function generateChatContainer() {
//   const chatContainer = document.createElement('div');
//   chatContainer.classList.add('chatContainer');
// }

function generateChatContainerUser(chatTxt) {
  const chatContainer = document.createElement('div');
  chatContainer.classList.add('chatContainerUser');
  const chatBody = document.querySelector('.chatBody');
  const messageElement = document.createElement('p');
  messageElement.className = "userMessage";
  // messageElement.className = "aiMessage"; 
  messageElement.textContent = chatTxt;
  chatContainer.appendChild(messageElement);
  chatBody.appendChild(chatContainer);
  const element = document.querySelector(".chatBody");
  element.scrollTo({ top: element.scrollHeight, behavior: "smooth" });
}

async function sendCompletionMesage(chatMesg) {
  const apiKey = "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"; // Replace with your actual API key
  const apiUrl = "https://api.openai.com/v1/chat/completions";

  const data = {
    model: "gpt-4",
    messages: [
      {
        role: "system",
        content: "If the user asks about our company: We are an advertising company that prints stickers, flex, UV prints, creates stands, and other advertising and printing products, including LED logos."
      },
      { role: "user", content: chatHistory }
    ]
  };

  // Display user message in chat

  try {
    const response = await fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${apiKey}`
      },
      body: JSON.stringify(data)
    });

    if (response.ok) {
      const result = await response.json();
      const aiResponse = result.choices[0].message.content;
      displayMessage(aiResponse); // Display AI's response
      // chatHistory.push({ role: "assistant", content: aiResponse });
      chatHistory+=("message hestory "+messagecounter+" {role: 'assistant', content: "+aiResponse+"}");
    } else {
      console.error("API request failed:", response.status, response.statusText);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}


document.addEventListener("click", function (event) {
  const chatBackground = document.getElementById("chatBack");
  const chatContainer = document.querySelector(".chatContainer");

  // Check if the click is outside the chatContainer
  if (!chatContainer.contains(event.target) && chatBackground.contains(event.target)) {
    chatBackground.style.display = "none"; // Hide the chat window
  }
});


function displayMessage(message) {
  const chatTxt= document.getElementById('chatTxt');
  chatTxt.disabled=false;
  const TypingMessage = document.querySelector('.TypingMessage');
  TypingMessage.remove();
  const chatContainer = document.createElement('div');
  const chatBody = document.querySelector('.chatBody');
  const messageElement = document.createElement('p');
  messageElement.className = "aiMessage"; // Style it with CSS if needed
  messageElement.textContent = message;
  chatContainer.appendChild(messageElement);
  chatBody.appendChild(chatContainer);
  const element = document.querySelector(".chatBody");
  element.scrollTo({ top: element.scrollHeight, behavior: "smooth" });
}


function TypingMessage(){
  const chatTxt= document.getElementById('chatTxt');
  chatTxt.disabled=true;
  const chatContainer = document.createElement('div');
  chatContainer.classList.add('TypingMessage');
  chatContainer.classList.add('aiMessage');
  const chatBody = document.querySelector('.chatBody');
  // const imageDis= document.createElement('img');
  const img = document.createElement('img');
  img.src = "loading-discord-grey.gif";
  img.alt = "Generated image";
  img.style.width = "50px";
  img.classList.add('generatedImageStyle');
  chatContainer.appendChild(img);
  chatBody.appendChild(chatContainer);
  const element = document.querySelector(".chatBody");
  element.scrollTo({ top: element.scrollHeight, behavior: "smooth" });
}
