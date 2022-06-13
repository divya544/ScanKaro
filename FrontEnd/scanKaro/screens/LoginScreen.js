// import {  StyleSheet,
//     Text,
//     View,
//     TextInput,
//     ScrollView,
//     Alert} from 'react-native';
// import { useForm } from "react-hook-form";
// import EditScreenInfo from '../components/EditScreenInfo';
// import { RootTabScreenProps } from '../types';
// import Container from '../components/Container';
// import Button from '../components/Button';
// import Label from '../components/Label';
// import Icon from 'react-native-vector-icons/FontAwesome';
//  const Input =({name,control})=>{
//      const {field}=useController({
//          control,
//          defaultValue:'',
//          name ,
//      })
//      return <TextInput value={field.value}
//        onChangeText={field.onChange}
//      />
//  }
// export default function LoginScreen() {
//     const userName = "";
//    // const validationSchema = Yup.object().shape({  })
//     const {control ,handleSubmit,onSubmit }=useForm();
//      const jojo=(data)=>{
//    //alert(JSON.stringify(data));
//     console.log("m",data)
//   // alert("gsjr")

//     }

//   return (
//     <ScrollView style={styles.scroll}>
//       <form onSubmit={(data) =>{
//           event.preventDefault();
//            console.log("hdhdhhdhdhdhhd", data)
//       }}>
//       <Container  style={styles.container} >
//                 <label text="Username or Email" >
//                 <TextInput type="text"  name="userName" />
//                 </label>
//             </Container>
//       <input type="submit"  />
//       </form>
//             <Container>
//                 <Button 
//                     label="Forgot Login/Pass" 
//                     styles={{button: styles.alignRight, label: styles.label}} 
//                     onPress={handleSubmit(onSubmit)}
//                    />
//             </Container>

//             <Container  style={styles.container} >
//                 <Label text="Username or Email" />
//                 <TextInput
//                     style={styles.textInput}
//                 />
//             </Container>
//             <Container>
//                 <Label text="Password" />
//                 <TextInput
//                     secureTextEntry={true}
//                     style={styles.textInput}
//                 />
//             </Container>

//             <Container>
//                     <Button 
//                         label="Sign In 2" 
//                         styles={{button: styles.primaryButton, label: styles.buttonWhiteText}} 
//                         onPress={handleSubmit(onSubmit)} 
//                          />
//                 </Container>

//             <View style={styles.footer}>
//                 <Container>
//                     <Button 
//                         label="Sign In" 
//                         styles={{button: styles.primaryButton, label: styles.buttonWhiteText}} 
//                          />
//                 </Container>
//                 <Container>
//                     <Button 
//                         label="CANCEL" 
//                         styles={{label: styles.buttonBlackText}} 
//                         />
//                 </Container>
//             </View>
//         </ScrollView>
//   );
// }

// const styles = StyleSheet.create({
//   container: {

//     marginLeft:50
//   },
//   title: {
//     fontSize: 20,
//     fontWeight: 'bold',
//   },
//   separator: {
//     marginVertical: 30,
//     height: 1,
//     width: '80%',
//   },

// });
// import React, { useState, useRef, useEffect } from 'react';
// export default function LoginScreen() {
//  //   const {control ,handleSubmit,onSubmit }=useForm();
//     const     [name, setName] = useState('');
//     const      input = useRef(     );
//     const jojo=(data)=>{
//         //    //alert(JSON.stringify(data));
//              console.log("m",data)
//         //   // alert("gsjr")

//              }
//    // useEffect(() => {
//     //  input.current.onkeyup = handleChange;
//    //   input.current.value = name;
//    // });

//     function handleChange(e) {
//       e.preventDefault();

//       setName(e.target.value);
//       console.log("hjg",name)
//     }

//     return (
//       <React.Fragment     >
//       <form onSubmit={handleChange}>
//         <div>
//           Name:
//           <input type='text' ref={input}  />
//         </div>
//         <input type="submit" onChange={handleChange} />
//         </form>
//     </React.Fragment>
//   );
// }
import React, { useState } from 'react';

export default function LoginScreen() {
    const [inputField, setInputField] = useState({
        first_name: '',
        last_name: ''
    })
    const inputsHandler = (e) => {
        const { name, value } = e.target;
        setInputField((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    }
    const submitButton = () => {
        console.log(inputField)
    }
    return (
        <div>
            <input
                type="text"
                name="first_name"
                onChange={inputsHandler}
                placeholder="First Name"
                value={inputField.first_name} />

            <br />
            <input
                type="text"
                name="last_name"
                onChange={inputsHandler}
                placeholder="Last Name"
                value={inputField.last_name} />

            <br />

            <button onClick={submitButton}>Submit Now</button>
        </div>
    )
}
