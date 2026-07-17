using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerScript : MonoBehaviour
{
    [SerializeField] private float m_Speed = 7f;
    [SerializeField] private float m_Jump = 12f; // Note: Reduced from 50f because direct velocity mode requires lower values

    private Rigidbody rb;
    private Vector2 moveInput;
    
    private float coyoteTimeCounter;
    [SerializeField] private float coyoteTimeDuration = 0.25f;

    [SerializeField] private Transform groundCheckPoint; 
    [SerializeField] private float groundRadius = 0.4f; 
    [SerializeField] private LayerMask groundLayer; 

    private void Awake()
    {
        rb = GetComponent<Rigidbody>();
        
        // Prevents your capsule from tipping over when hitting obstacles
        rb.freezeRotation = true; 
    }

    public void OnMove(InputValue value)
    {
        moveInput = value.Get<Vector2>();
    }

    public void OnJump(InputValue value)
    {
        // If the jump key is pressed down AND our coyote time window is still active
        if (value.isPressed && coyoteTimeCounter > 0f)
        {
            rb.linearVelocity = new Vector3(
                rb.linearVelocity.x,
                m_Jump,
                rb.linearVelocity.z
            );

            // Instantly empty the coyote timer so the player can't double-jump in mid-air
            coyoteTimeCounter = 0f; 
        }
    }

    private void FixedUpdate()
    {   
        // 1. Check ground state every physics frame
        bool isGrounded = Physics.CheckSphere(groundCheckPoint.position, groundRadius, groundLayer);
        
        // 2. Manage the coyote time grace period countdown
        if (isGrounded) 
        {
            coyoteTimeCounter = coyoteTimeDuration; // Reset timer while touching the ground
        }
        else 
        {
            coyoteTimeCounter -= Time.fixedDeltaTime; // Count down when walking off edges
        }
        
        // 3. Apply custom gravity multiplier
        rb.AddForce(Physics.gravity * 3f, ForceMode.Acceleration);
        
        // 4. Calculate camera/player-relative movement direction
        Vector3 moveDirection = (transform.forward * moveInput.y) + (transform.right * moveInput.x);
        
        // 5. Apply movement velocity without zeroing out your upward jump velocity
        rb.linearVelocity = new Vector3(
            moveDirection.x * m_Speed,
            rb.linearVelocity.y,
            moveDirection.z * m_Speed
        );
    }

    public void Die()
    {
        transform.position = new Vector3(0,0,0);      
        coyoteTimeCounter = 0;
        rb.linearVelocity = new Vector3(0, 0, 0);    
    }
}