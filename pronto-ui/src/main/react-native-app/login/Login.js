import React, {Component} from 'react';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';
import {Platform, StyleSheet, Text, View, Image, TextInput, Button, Alert} from 'react-native';

export default class Login extends Component {
    render() {
        return (
            <KeyboardAwareScrollView scrollEnabled={false}
                 resetScrollToCoords={{x: 0, y: 0}}
                 contentContainerStyle={styles.container}>
                <Image style={styles.loginImages} source={require('./theDaves.jpg')}/>
                <TextInput placeholder='  username' placeholderTextColor='#61685e' style={styles.textInput}/>
                <TextInput placeholder='  password'
                     textContentType='password'
                     secureTextEntry={true}
                     placeholderTextColor='#61685e'
                     style={styles.textInput}/>
                <Button title="Sign In" color='#61685e' style={styles.button}
                    onPress={() => {
                            Alert.alert('Logged In');
                            }}/>
            </KeyboardAwareScrollView>
        );
    }
}

const styles = StyleSheet.create({
    container: {
      // flex: 1,
      alignItems: 'center',
    },
    loginImages: {
      // flex: 1,
      left: 20,
      marginTop: 50,
      height: 180,
      width: 180,
      borderRadius: 90,
    },
    textInput: {
      marginTop: 15,
      color: '#61685e',
      width: 210
    },
    button: {
      marginTop: 20
    }
});
