using UnityEngine;
using UnityEngine.InputSystem;

public class CameraMouseLook : MonoBehaviour
{
    public float mouseSensitivity = 0.1f;
    public float minVerticalAngle = -20f;
    public float maxVerticalAngle = 60f;

    private float currentHorizontalAngle = 0f;
    private float currentVerticalAngle = 20f; 

    void Start()
    {
        Cursor.lockState = CursorLockMode.Locked;
    }
    /*
    void Update()
    {
        Vector2 mouseDelta = Mouse.current.delta.ReadValue();
        currentHorizontalAngle += mouseDelta.x * mouseSensitivity;
        currentVerticalAngle -= mouseDelta.y * mouseSensitivity;
        currentVerticalAngle = Mathf.Clamp(currentVerticalAngle, minVerticalAngle, maxVerticalAngle);
        transform.rotation = Quaternion.Euler(currentVerticalAngle, currentHorizontalAngle, 0f);
    }
    */
    [Header("References")]
[SerializeField] private Transform playerCamera; // Drag your Main Camera here in the Inspector!

void Update()
{
    Vector2 mouseDelta = Mouse.current.delta.ReadValue();
    
    // 1. Calculate the rotation angles
    currentHorizontalAngle += mouseDelta.x * mouseSensitivity;
    currentVerticalAngle -= mouseDelta.y * mouseSensitivity;
    currentVerticalAngle = Mathf.Clamp(currentVerticalAngle, minVerticalAngle, maxVerticalAngle);
    
    // 2. Rotate the PLAYER left and right (Y-axis rotation)
    transform.rotation = Quaternion.Euler(0f, currentHorizontalAngle, 0f);
    
    // 3. Rotate ONLY THE CAMERA up and down (X-axis rotation)
    if (playerCamera != null)
    {
        playerCamera.localRotation = Quaternion.Euler(currentVerticalAngle, 0f, 0f);
    }
}
}
